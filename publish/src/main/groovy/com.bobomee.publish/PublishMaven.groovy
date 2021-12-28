package com.bobomee.publish

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.component.SoftwareComponent
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPom
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin

class PublishMaven implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def publishingConfig = project.extensions.create("publishConfig", PublishConfig)

        project.plugins.apply MavenPublishPlugin
        PublishingExtension publishing = project.extensions.getByType(PublishingExtension)
        def publishLocal = publishingConfig.local
        def publishSnapshot = publishingConfig.snapshot
        def publishLocalUrl = publishingConfig.repoLocal
        def publishLocalUrlEmpty = publishLocalUrl.isEmpty()
        def publishRepoUrl = publishSnapshot? publishingConfig.repoSnapshot : publishingConfig.repoRelease

        project.afterEvaluate {
            for (SoftwareComponent components : project.components) {
                publishing.publications({ publications ->
                    publications.create(components.name, MavenPublication.class, { MavenPublication publication ->
                        publication.groupId = publishingConfig.groupId
                        publication.artifactId = publishingConfig.artifactId
                        publication.version = publishingConfig.version
                        publication.from(components)
                        publication.pom {
                            mavenPom -> configPom(mavenPom, publishingConfig)
                        }
                    })
                })
            }

            publishing.repositories { artifactRepositories ->
                if (publishLocal){
                    if (publishLocalUrlEmpty){
                        mavenLocal()
                    }else {
                        avenArtifactRepository.url = publishLocalUrl
                    }
                } else {
                    mavenArtifactRepository.url = publishRepoUrl
                    mavenArtifactRepository.credentials {
                        credentials ->
                            credentials.username = publishingConfig.repoName
                            credentials.password = publishingConfig.repoPassword
                    }
                }
            }
        }
    }

    static void configPom(MavenPom mavenPom, PublishConfig config) {
        mavenPom.name = config.pomName
        mavenPom.description = config.pomDescription
        mavenPom.url = config.pomUrl
    }
}