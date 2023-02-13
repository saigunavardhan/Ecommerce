package com.Ecommerce.Amazon.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@AllArgsConstructor
public class ApiResponse {

   private final Boolean success;
   private final String message;

   public Boolean isSuccess(){
       return success;
   }
}
