package com.mycy.repository;

import com.mycy.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Use repository when you want to bring data from a database. Since thymeleaf understands
 * java objects, create methods to manipulate the data, then display it on the UI.
 * When repositories make sure to extend the JpaRepository<repositoryName, dataType>
 * The common ways of writing queries are derived queries and @Query annotation queries.
 * There is a third option to write queries using Named Queries. The queries can be defined
 * in a properties file, or in an XML file (very old way). Syntax inside the properties file:
 * entityName.methodName=query(e.g. select e from Employee Order by salary desc)
 * Note that writing derived queries is good only with methods having 3-4 parameters, otherwise
 * it would be difficult or almost impossible to read and maintain these queries when adding,
 * filtering, comparison, and result size limiting. For this reason you rather use more flexible
 * queries such as JPQL (Java Persistence Query Language) or native SQL queries
 * (e.g. select * from tableName).
 * The @Query annotation is used for both JPQL and native queries
 * JPQL
 * Since JPQL supports the SQL subset standard, it is not a good
 * choice to use it for more complex queries. JPQL is an abstraction, it might have slight
 * performance issue (The flow is: JPQL => convert to sql ==> access database)
 * When writing JPQL queries through @Query annotations, you may specify parameters through
 * methods either positional parameter use ?parameterName or name-binding parameters.
 * Note that JPQL method names does not matter, it can be any descriptive name
 * In the method signature name-binding parameter uses the @Param("parameterName") annotation,
 * when writing the query uses :parameterName
 * Native SQL
 * To write native SQL make sure pass the nativeQuery = true into the @Query annotation
 * RollingBack
 * If anything happens during inserting, updating, and deleting, the data should roll back
 * to the original state. Use @Modifying, @Transactional annotations
 */
public interface RegionRepository extends JpaRepository<Region, Long> {
    //Requirement: display all regions in Canada
    //to create custom method use driver queries: syntax: introducer(get, find, read)delimiter(By)Interest
    List<Region> findByCountry(String country);//equal to the query => select country from region

    //display all regions in Canada without duplicates
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country);

    //Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    //Display top 2 regions in Canada
    List<Region> findTopByCountry(String country);
}
