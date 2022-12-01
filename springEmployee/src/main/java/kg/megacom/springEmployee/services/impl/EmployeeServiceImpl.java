package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.Employee;
import kg.megacom.springEmployee.models.Position;
import kg.megacom.springEmployee.models.enums.EmployeeStatus;
import kg.megacom.springEmployee.repositories.AccountRepository;
import kg.megacom.springEmployee.repositories.EmployeeRepository;
import kg.megacom.springEmployee.repositories.PositionRepository;
import kg.megacom.springEmployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AccountRepository accountRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AccountRepository accountRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.accountRepository = accountRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public Employee save(Employee employee) {
        Account account = accountRepository.save(employee.getAccount());
        employee.setAccount(account);
        employee.setAddDate(new Date());
        Position position = positionRepository.save(employee.getPosition());
        employee.setPosition(position);
        employee.setEmployeeStatus(EmployeeStatus.ACTIVE);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
