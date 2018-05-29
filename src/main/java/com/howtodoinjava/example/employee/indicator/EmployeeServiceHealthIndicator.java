package com.howtodoinjava.example.employee.indicator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.howtodoinjava.example.employee.controller.EmployeeServiceController;

@Component
public class EmployeeServiceHealthIndicator implements HealthIndicator {

	@Autowired
	private EmployeeServiceController employeeService;

	@Override
	public Health health() {
		try {
			Health.Builder healthBuilder;
			healthBuilder = employeeService.isServiceUp() ? Health.up() : Health.down();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
			LocalDateTime availableSince = employeeService.getAvailableSince();
			return healthBuilder.withDetail("up since", availableSince.format(dateTimeFormatter))
					.build();

		} catch (Exception e) {
			return Health.down(e).build();
		}
	}
}