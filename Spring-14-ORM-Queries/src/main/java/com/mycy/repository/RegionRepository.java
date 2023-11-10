package com.mycy.repository;

import com.mycy.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
