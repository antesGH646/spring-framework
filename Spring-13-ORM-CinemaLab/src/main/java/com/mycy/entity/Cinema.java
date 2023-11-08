package com.mycy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
//@Data //converted to @Getter and @Setter to avoid infinite toString() looping
@Getter
@Setter
public class Cinema extends BaseEntity{

   private String name;
   private String sponsoredName;

   @ManyToOne(fetch = FetchType.LAZY)
   private Location location;

   @Override
   public String toString() {
      return "Cinema{" +
              "name='" + name + '\'' +
              ", sponsoredName='" + sponsoredName + '\'' +
              '}';
   }
}
