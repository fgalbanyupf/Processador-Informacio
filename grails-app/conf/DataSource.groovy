dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    username = "pdc"
    password = "pdc"
    properties {
        maxActive = 50
        maxIdle = 25
        minIdle = 5
        initialSize = 5
        minEvictableIdleTimeMillis = 60000
        timeBetweenEvictionRunsMillis = 60000
        maxWait = 10000
        validationQuery = "select 1"
    }
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
          development {
		    dataSource {
			      //dbCreate = "create-drop" // one of 'create', 'create-drop','update'
			      //url = "jdbc:mysql://192.168.1.243:3306/dev_yapdc?useUnicode=yes&characterEncoding=UTF-8"
                              
                              dbCreate  = "update"
                              //url = "jdbc:mysql://192.168.1.243:3306/dailyflats"
                              url = "jdbc:mysql://localhost:3306/bi_base"
                              username = "root"
                              password = "root"
                              
		    }
                    
	  }
	  test {
		    dataSource {
			      dbCreate = "create"
			      url = "jdbc:mysql://192.168.1.243:3306/test_yapdc"
		    }
	  }
	  production {
		    dataSource {
			      dbCreate  = "update"
                              url = "jdbc:mysql://127.0.0.1:3306/dailyflats"
                              username = "pdc"
                              password = "pdc"
			      //url = "jdbc:mysql://192.168.1.243:3306/yapdc"
                              //url = "jdbc:mysql://127.0.0.1/yapdc_vc?useUnicode=yes&characterEncoding=UTF-8"
                              //url = "jdbc:mysql://192.168.1.243:3306/yapdc_be"
                              //OJUUU VALLCOMPANYS!!
		    }
	  }
}
/*dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            properties {
               // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
               jmxEnabled = true
               initialSize = 5
               maxActive = 50
               minIdle = 5
               maxIdle = 25
               maxWait = 10000
               maxAge = 10 * 60000
               timeBetweenEvictionRunsMillis = 5000
               minEvictableIdleTimeMillis = 60000
               validationQuery = "SELECT 1"
               validationQueryTimeout = 3
               validationInterval = 15000
               testOnBorrow = true
               testWhileIdle = true
               testOnReturn = false
               jdbcInterceptors = "ConnectionState"
               defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
*/