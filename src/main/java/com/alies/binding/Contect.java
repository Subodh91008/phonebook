package com.alies.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contect {
  private Integer id;
  private String name;
  private long phonenumber;
  private String email;
}
