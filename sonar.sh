sonar.java.binaries=target/classes/tn/esprit/kaddemproject
 sonar-scanner \
               -Dsonar.projectKey=bilel \
               -Dsonar.sources=./src \
               -Dsonar.host.url=http://localhost:9000 \
               -Dsonar.login=admin \
               -Dsonar.password=sonar
          
