FROM node:17.8-alpine AS builder
# Set working directory
WORKDIR /app

COPY package.json .
RUN npm install 
# Copy all files from current directory to working dir in image
COPY . .
# install node modules and build assets
RUN npm run build

# nginx state for serving content
FROM nginx:alpine

COPY --from=builder /app/build /usr/share/nginx/html
