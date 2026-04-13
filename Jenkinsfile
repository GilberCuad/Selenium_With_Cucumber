pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    environment {

        REPORT_DIR = 'target/cucumber-html-reports'
    }

    parameters {
        string(
            name: 'CUCUMBER_TAGS',
            defaultValue: '',
            description: 'Tag a ejecutar, ejemplo: @smoke  |  Dejar vacío para ejecutar todos'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                echo '📥 Clonando repositorio...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '🔨 Compilando el proyecto...'
                sh 'mvn clean compile test-compile -q'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Ejecutando tests de Selenium + Cucumber...'
                script {
                    // Si se pasó un tag, filtra por él; si no, corre todos
                    def tagsParam = params.CUCUMBER_TAGS?.trim()
                    def tagsArg   = tagsParam
                        ? "-Dcucumber.filter.tags=\"${tagsParam}\""
                        : ''

                    sh """
                        mvn test \
                            -Dheadless=true \
                            ${tagsArg} \
                            --no-transfer-progress
                    """
                }
            }
            post {
                always {
                    echo '📊 Publicando resultados JUnit...'
                    junit(
                        testResults: 'target/surefire-reports/**/*.xml',
                        allowEmptyResults: true
                    )
                }
            }
        }

        stage('Publish Report') {
            steps {
                echo '📈 Publicando reporte Cucumber HTML...'
                publishHTML([
                    allowMissing         : true,
                    alwaysLinkToLastBuild: true,
                    keepAll              : true,
                    reportDir            : 'target/cucumber-html-reports',
                    reportFiles          : 'overview-features.html',
                    reportName           : 'Cucumber Report'
                ])
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline finalizado: todos los tests pasaron.'
        }
        unstable {
            echo '⚠️  Pipeline inestable: algunos tests fallaron (revisar reporte).'
        }
        failure {
            echo '❌ Pipeline falló: error en compilación o configuración.'
        }
        always {
            echo '🧹 Limpieza finalizada.'
            cleanWs()
        }
    }
}