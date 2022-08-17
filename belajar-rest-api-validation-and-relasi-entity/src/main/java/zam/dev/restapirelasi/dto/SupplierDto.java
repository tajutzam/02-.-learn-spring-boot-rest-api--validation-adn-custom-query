package zam.dev.restapirelasi.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class SupplierDto {


    @NotEmpty(message = "name is required")
    private String nama_supplier;

    @NotEmpty(message = "Addres is required")
    private String address;

    @NotEmpty(message = "Email  is required")
    @Email(message = "Email Not valid ")
    private String email;

}
