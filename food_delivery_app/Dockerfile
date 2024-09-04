
# Stage 1: Build the Angular app

FROM node:20 As build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Serve the Angular app using Nginx
FROM nginx:stable
RUN rm -rf /usr/share/nginx/html/*
COPY --from=build /app/dist/food_delivery_app/browser /usr/share/nginx/html
# COPY --from=build /app/food_delivery_app /usr/share/nginx/html
RUN chmod -R 755 /usr/share/nginx/html/
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
