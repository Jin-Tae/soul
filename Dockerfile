FROM openjdk:11
ENV TZ=Asia/Seoul
#ADD ./soulbrain-board.jar soulbrain-board.jar
ARG JAR_FILE=soulbrain-board.jar
COPY build/libs/${JAR_FILE} soulbrain.jar
ENTRYPOINT ["java","-jar","soulbrain.jar"]