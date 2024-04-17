FROM openjdk:latest
WORKDIR /usr/src/app
COPY ./src/main/java .
RUN javac -sourcepath . -d out ./Java_Core_Seminar1/Main.java
WORKDIR /usr/src/app/out
#CMD java -classpath . Java_Core_Seminar1/Main
ENTRYPOINT ["java", "Java_Core_Seminar1/Main"]