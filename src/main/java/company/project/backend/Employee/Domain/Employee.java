package company.project.backend.Employee.Domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	@ApiModelProperty(notes = "Employee UUID")
	private UUID uuid;
	@ApiModelProperty(notes = "Employee Name")
	private String name;
	@ApiModelProperty(notes = "Employee Address")
	private String address;
}