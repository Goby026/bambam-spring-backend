package core.dev.bambam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BambamApplication implements CommandLineRunner {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BambamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "123";

		for (int i = 0; i < 2; i++) {
			String pw = this.passwordEncoder.encode(password);

			System.out.println(pw);
		}
	}
}
