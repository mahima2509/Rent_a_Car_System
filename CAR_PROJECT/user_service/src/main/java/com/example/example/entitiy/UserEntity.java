package com.example.example.entitiy; // Fix typo in package name


import lombok.Data;
import jakarta.persistence.*; // Import necessary JPA annotations

@Data
@Entity // Specify that this class is an entity
@Table(name = "UserEntity") // Use the correct table name
public class UserEntity {

    @Id
    @Column(name = "userId") // Map to userId column
    private String userId; // Assuming userId is a String based on your insert example

    @Column(nullable = false) // Username is required
    private String username;

    @Column(nullable = false) // Password is required
    private String password; // Include the password field

    @Column(nullable = false) // Address is required
    private String address;

    @Column(nullable = false, unique = true) // Email is required and must be unique
    private String email;

    @Column(nullable = false) // Roles are required
    private String roles; // Consider using a Set<String> or Enum for roles

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
    
    
}
