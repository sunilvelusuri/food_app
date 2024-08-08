
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







# # Stage 1: Build the Angular application
# FROM node:20 as build

# # Set the working directory
# WORKDIR /app

# # Copy package.json and package-lock.json
# COPY package*.json ./

# # Install dependencies
# RUN npm install

# # Copy the rest of the application code
# COPY . .

# # Build the Angular application
# RUN npm run build --prod


# # Stage 2: Serve the Angular application using Nginx
# FROM nginx:alpine

# # Remove default Nginx static assets
# RUN rm -rf /usr/share/nginx/html/*

# # Copy the Angular build output to the Nginx HTML directory
# COPY --from=build /app/dist/food_delivery_app /usr/share/nginx/html

# # Copy the default Nginx configuration file
# RUN chmod -R 755 /usr/share/nginx/html

# # Expose port 80
# EXPOSE 80

# # Start Nginx server
# CMD ["nginx", "-g", "daemon off;"]
