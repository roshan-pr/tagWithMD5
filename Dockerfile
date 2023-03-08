FROM debian

RUN apt-get update
RUN apt-get install -y curl
# RUN apt-get install -y python3
RUN rm -rf /var/lib/apt/lists/*
