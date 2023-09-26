# Link Shortener

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Contributing](#contributing)


## Introduction

The **Link  Shortener** is a simple yet powerful tool that allows you to create short links based on user-provided aliases. This project uses an in-memory H2 database to store and retrieve the shortened links and their corresponding aliases. It can be helpful in scenarios where you want to create custom short links for specific individuals or purposes.

## Features

- Shorten URLs with custom aliases.
- Store and manage shortened links in an in-memory H2 database.
- Retrieve the original URL using the custom alias. The url redirects to the initial web page prior to shortening the website

## Installation

To install and run the Link Shortener with Alias, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/nuelladev/Link-shortener.git
2. **Navigate to the Project Directory:**
   cd link-shortener
3. **Run the Application**

## Usage
Once the application is up and running, you can interact with it via a RESTful API. 

## Configuration
You can configure the application by editing the application.properties file or by using environment variables. Here are some configurable options:

**server.port:** The port on which the application will run (default is 8080).
**spring.datasource.url:** The URL for the H2 in-memory database.
**spring.datasource.username:** The username for the database.
**spring.datasource.password:** The password for the database.

## Contributing
Contributions to this project are welcome! If you'd like to contribute, please follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and test thoroughly.
Create a pull request with a clear description of your changes.





