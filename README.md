# curriculum_backend

### Installation

1. **Clone the repository**

2. **Database Setup**

    Ensure you have MySQL installed and running.

    Import the database schema from the dataBase folder into your MySQL database.

3. **Configure Database Connection:**

Open src/main/resources/application.properties and configure the database connection properties:

   spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword

4. **Run the application**

    Build the project with Maven if it's necessary and run the application
