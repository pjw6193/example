package com.skillstorm.maven;

/**

Apache Maven (open source projects)

build tool

where are all the .java files? Where are the resources? 
	standardized folder structure
		src/main/java
		src/main/resources
		src/test/java
		src/test/resources
	archetype (pre-configured code)

phases "build steps" - pre-maven: by-hand / script, Linux, shell, Powershell
	compile -> (((test -> package (JAR)))) -> install -> deploy
		    never build bad code (test fails/build fails)

goal: command you want to execute, may or may not be tied to a phase

mvn compile 	# compile my code
mvn package	# compile, test, package


Project Coordinates:
	groupId		organization, com.skillstorm
	artifactId	project, benefits-app
	version		1.2.3, major.minor.incremental
			major - significant release 
			minor - less signifcant (improve/add features to a release)
			incremental - build number
			12.1.4539
			1.2.3-SNAPSHOT (not a complete build)
			1.2.3-RELEASE (full release)


POM - Project Object Model
	XML file that represents the project configuration
	XML is a markup language to 'tag' data
 * 
 * 
 */
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello Maven");
	}

}
