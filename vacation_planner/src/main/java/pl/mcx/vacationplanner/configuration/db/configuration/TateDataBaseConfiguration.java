package pl.mcx.vacationplanner.configuration.db.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;

import javax.sql.DataSource;


@Configuration
public class TateDataBaseConfiguration {

    @Autowired
    @Qualifier(value = "jpaVendorAdapterTate")
    private JpaVendorAdapter jpaVendorAdapterTate;

    @Bean
    @ConfigurationProperties(prefix = "tate.datasource")
    public DataSource tateDataSource() {
        return DataSourceBuilder.create()
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplateTate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(tateDataSource());
        return jdbcTemplate;
    }

//    @Bean(name = "tateEntityManager")
//    public EntityManager tateEntityManager(
//            @Qualifier("tateEntityManagerFactory") EntityManagerFactory tateEntityManagerFactory) {
//        return tateEntityManagerFactory.createEntityManager();
//    }
//
//    @Bean(name = "tateEntityManagerFactory")
//    public EntityManagerFactory tateEntityManagerFactory(
//            @Qualifier("tateDataSource") DataSource tateDataSource) {
//        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
//        lef.setDataSource(tateDataSource);
//        lef.setJpaVendorAdapter(jpaVendorAdapterTate);
//        lef.setPersistenceUnitName("tatePersistenceUnit");
//        lef.afterPropertiesSet();
//        return lef.getObject();
//    }
//
//    @Bean(name = "tateTransactionManager")
//    public PlatformTransactionManager tateTransactionManager(
//            @Qualifier("tateEntityManagerFactory") EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }

}
