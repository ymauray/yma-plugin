package dk.yma.gradle;

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.GroovyPlugin;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.MavenPlugin;
import org.gradle.plugins.ide.eclipse.EclipsePlugin;

class YmaPlugin implements Plugin<Project> {
    void apply(Project project) {
    	project.plugins.apply(JavaPlugin.class)
    	project.plugins.apply(GroovyPlugin.class)
    	project.plugins.apply(EclipsePlugin.class)
		project.plugins.apply(MavenPlugin.class)

    	project.tasks.eclipse.dependsOn(project.tasks.cleanEclipse)

		project.eclipse.project {
			file {
				beforeMerged { eclipseProject ->
					eclipseProject.natures.clear()
				}
			}
			natures 'org.springframework.ide.eclipse.core.springnature'
			buildCommand 'org.springframework.ide.eclipse.core.springbuilder'
		}

		project.eclipse.classpath {
			file {
				beforeMerged { eclipseClasspath ->
					eclipseClasspath.entries.removeAll()
				}
			}
			//containers 'GROOVY_SUPPORT'
		}

		project.repositories {
			mavenCentral()
		}
		
		project.dependencies {
			compile 'org.springframework:spring-context:3.2.5.RELEASE'
			compile 'org.codehaus.groovy:groovy-all:2.1.6'
			compile 'com.google.guava:guava:13.0.1'
			compile 'log4j:log4j:1.2.17'
			compile 'org.slf4j:slf4j-api:1.7.5'
			compile 'org.slf4j:slf4j-log4j12:1.7.5'

			runtime 'org.springframework:spring-aop:3.1.4.RELEASE'
			runtime 'org.aspectj:aspectjrt:1.7.3'	
		}
    }
}
