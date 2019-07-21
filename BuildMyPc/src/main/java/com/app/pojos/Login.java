package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
		@Id
		@Column(name="Email",length=30)
		private String email;
		@Column(name="Password",length=30)
		private String password;
		@Column(name="Role",length=10)
		private String role;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "Login [email=" + email + ", password=" + password + ", role=" + role + "]";
		}
		
		
		

}
