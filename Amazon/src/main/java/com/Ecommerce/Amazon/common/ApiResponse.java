package com.Ecommerce.Amazon.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiResponse {

   private final Boolean success;
   private final String message;

   public Boolean isSuccess(){
       return success;
   }
   public String getTimeStamp(){
       return LocalDateTime.now().toString();
   }
}
