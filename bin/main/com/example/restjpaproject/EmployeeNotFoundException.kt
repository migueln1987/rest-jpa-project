package com.example.restjpaproject

import java.lang.RuntimeException

class EmployeeNotFoundException(val id: Long) :
        RuntimeException("Could not find employee $id")