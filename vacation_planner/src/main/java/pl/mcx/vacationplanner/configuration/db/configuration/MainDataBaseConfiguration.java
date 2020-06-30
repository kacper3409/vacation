package pl.mcx.vacationplanner.configuration.db.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.mcx.vacationplanner.repository.main.TicketRepository;
import pl.mcx.vacationplanner.repository.main.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@EnableJpaRepositories(basePackageClasses = {TicketRepository.class, UserRepository.class},
        entityManagerFactoryRef = "mainEntityManagerFactory",
        transactionManagerRef = "mainTransactionManager")
@Configuration
@EnableTransactionManagement
public class MainDataBaseConfiguration {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean
//    @Primary
    public DataSource mainDataSource(@Value("${main.datasource.url}") String url,
                                     @Value("${main.datasource.password}") String password,
                                     @Value("${main.datasource.username}") String userName,
                                     @Value("${main.datasource.driver-class-name}") String driver) {
        return DataSourceBuilder.create()
                .url(url)
                .password(password)
                .username(userName)
                .driverClassName(driver)
                .build();
    }

    //    @Primary
    @Bean(name = "mainEntityManager")
    public EntityManager mainEntityManager(
            @Qualifier("mainEntityManagerFactory") EntityManagerFactory mainEntityManagerFactory) {
        return mainEntityManagerFactory.createEntityManager();
    }

    //    @Primary
    @Bean(name = "mainEntityManagerFactory")
    public EntityManagerFactory mainEntityManagerFactory(
            @Qualifier("mainDataSource") DataSource mainDataSource) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(mainDataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("pl.mcx.vacationplanner.entity");
        lef.setPersistenceUnitName("mainPersistenceUnit");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    //    @Primary
    @Bean(name = "mainTransactionManager")
    public PlatformTransactionManager mainTransactionManager(
            @Qualifier("mainEntityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
