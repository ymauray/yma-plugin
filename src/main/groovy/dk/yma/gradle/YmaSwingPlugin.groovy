package dk.yma.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project;

class YmaSwingPlugin implements Plugin<Project> {

	def void apply(Project project) {
		project.plugins.apply YmaPlugin
		
		project.dependencies {
			compile 'com.jgoodies:jgoodies-looks:2.5.2'
			compile 'com.jgoodies:jgoodies-validation:2.4.2'
            compile 'com.jgoodies:jgoodies-forms:1.6.0'
            compile 'com.jgoodies:jgoodies-binding:2.7.0'
            compile 'com.jgoodies:jgoodies-animation:1.4.2'
		}
	}
}
