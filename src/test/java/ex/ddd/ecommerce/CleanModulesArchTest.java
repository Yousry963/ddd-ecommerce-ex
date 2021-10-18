package ex.ddd.ecommerce;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideOutsideOfPackages;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

class CleanModulesArchTest {

	@Test
	void om_service_has_no_dependency_on_others() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("ex.ddd.ecommerce.ordermanagement");
		ArchRule rule = classes().should().onlyDependOnClassesThat(
				resideOutsideOfPackages("ex.ddd.ecommerce..").or(resideInAPackage("ex.ddd.ecommerce.ordermanagement..")
						.or(resideInAPackage("ex.ddd.ecommerce.common.."))));
		rule.check(importedClasses);
	}

	/*
	 * @Test void payment_service_has_no_dependency_on_others() { JavaClasses
	 * importedClasses = new
	 * ClassFileImporter().importPackages("ex.ddd.ecommerce.payment"); ArchRule rule
	 * = classes().should().onlyDependOnClassesThat(
	 * resideOutsideOfPackages("ex.ddd.ecommerce..").or(resideInAPackage(
	 * "ex.ddd.ecommerce.payment..")
	 * .or(resideInAPackage("ex.ddd.ecommerce.common.."))));
	 * rule.check(importedClasses); }
	 */

}
