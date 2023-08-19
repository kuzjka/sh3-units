FROM nginx:alpine

WORKDIR /usr/share/nginx/html

RUN rm -rf ./*

COPY nginx/default.conf.template /etc/nginx/templates/
COPY nginx/proxy.conf /etc/nginx/
COPY dist/sh3-units-web/ .

ENV SERVER_HOST="localhost" \
    SERVER_PORT=80 \
    BACKEND_URL="http://service:8080"
