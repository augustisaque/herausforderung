package com.example.tsystems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Pessoa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa implements AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull(message = "The field 'Name' is mandatory!")
	@Column(nullable = false)
	private String name;
	
	@NotNull(message = "The field 'Last Name' is mandatory!")
	@Column(nullable = false)
	private String lastname;
	
	@NotNull(message = "The field 'Age' is mandatory!")
	@Column(nullable = false)
	private Integer age;
	
	@NotNull(message = "The field 'Sex' is mandatory!")
	@Column(nullable = false)
	private String sex;

}
