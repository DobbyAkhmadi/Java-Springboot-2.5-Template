package company.project.backend.Employee.Domain;

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
	private UUID id = UUID.randomUUID();
	private String name;
	private String address;
}
