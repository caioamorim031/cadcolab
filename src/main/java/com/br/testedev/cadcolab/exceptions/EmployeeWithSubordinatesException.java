package com.br.testedev.cadcolab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee associated with subordinates. Exclusion is not acceptable! ")
public class EmployeeWithSubordinatesException extends RuntimeException {

}
