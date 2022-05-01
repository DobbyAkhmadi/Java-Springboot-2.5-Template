package company.project.backend.Employee.Domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(16)")
	@ApiModelProperty(notes = "ID UUID Auto Generated",allowEmptyValue = false)
	private UUID id = UUID.randomUUID();
	@ApiModelProperty(notes = "Employee Name",allowEmptyValue = true)
	private String name;
	@ApiModelProperty(notes = "Employee Address",allowEmptyValue = true)
	private String address;
}
