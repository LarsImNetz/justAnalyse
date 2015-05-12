package experiment.lars.dependency.injection.assistedinjection;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

public class Simple {

	String a;
	IService service;

	// assisted sind alle Parameter, die nicht per Injection gesetzt werden sollen

	@Inject
	Simple(final IService service, @Assisted final String a) {
		this.service = service;
		this.a = a;
	}

	String doSomething() {
		return a + service.something();
	}
}
