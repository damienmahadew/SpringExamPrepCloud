/**
 * Created by DAMIEN6 on 01/11/2016.
 */
package za.co.mahadew.damien.notes;

/**
 * Objectives?
 *  Describe microservies
 *  discuss their advantages and challenges
 *  implement a small system using spring cloud
 *
 * Microservices
 *  Not a new concept
 *      term coined by Dr Peter Rodgers in 2005 - called it Micro web services (only soap was available at the time)
 *   *Microservices hold great promise for exposing functionality to the outside world. They allow
 *    organizations to quickly connect disparate systems in a platform neutral manner
 *
 *    Classic vs Microservice architecture
 *    Classic
 *      Client -> [Monolithic application (HTML, JS, Services, Data Access)] -> Database
 *
 *    Microservice
 *      Client -> Front end -> Microservice App (1-n) -> relational DB or NoSQL or Key Value store
 *
 * Three tier architecture
 *  Single monilithic application does everything
 *      access database, business logic, etc
 *  Classic JEE and /or Spring application
 *      application server runs the big app
 *  Single large development team
 *  separate OPS, DBA's, Dev teams
 *  all data in single relational DB
 *      using multiple data sources in the same application is harder
 *
 * Microservices features
 *  Multi language
 *      not all the services need to be in the same language
 *          or use the same framework
 *          e.g. java+spring+tomcat, ruby+rails, nodejs+JS
 *  Polyglot persistence
 *      each service uses the most suitable storage system
 *          relational DB, key-value sotre, document store
 *  Standalone development
 *      develop, test and deploy each service independently
 *      separate teams, leverage Dev Ops
 *
 *  Trade offs
 *  Single app
 *      Easier to build
 *      Large process to deploy
 *      ultimately more complex to enhance and maintain
 *      scaling up(bigger processors) limited
 *      - Easier but more complex
 *  Microservices
 *      Harder to build
 *      Network overheads
 *      ultimately simpler to extend and maintain
 *      scaling out(more processes) easier
 *      -harder but simpler
 *
 * Core spring concepts
 *  Spring emphasizes
 *      -loose coupling
 *          applications are built from collaborating services(processes)
 *          similar to Service Oriented Architecture (SOA)
 *              but using todays tech
 *      -Tight cohesion
 *          an application(service) that deals with a single view of data
 *          also known as bouded contexts (Domain Driven Design)
 *  Enterprise integration patterns
 *      microservices - logical extension
 *
 *
 * Why Cloud, Why PaaS?
 *  Deploying multiple processes is complicated
 *      security, resilience, redundancy, load-balancing
 *  A could PaaS provides the necessary tools to :
 *      natural fit for deploying a microservice based system
 *      application is the unit of deployment
 *      application instances are the unit of scaling
 *      start, stop and restart apps independently, on -demand
 *      provide dynamic load balancing, scaling and routing
 *
 * Cloud Native Applications
 *  Applications
 *      Designed to run "in the cloud"
 *      in isolated, disposable containers
 *          fast to scale up and scale down
 *  Make no assumptions about the underlying ifrastructure
 *      local file-system transient
 *      sessions lost on restart
 *  Should design applications to suit this environment
 *      Use Twelve Factor Application design pattern
 *
 * Building Blocks
 *  Several companies have tackled microservices
 *      created useful infrastructure facilities
 *          service registration and discovery
 *          dynamic (re)configuration
 *          laod balancing between service instances
 *          efficient failure handling if a service is unavailable
 *      and made much of the work open source
 *  Spring cloud
 *      distributed system patterns for the web
 *          wrap the OSS components, so you dont have to lean/understand them
 *
 * Why Spring Boot
 *  Java-bassed microservices often use Spring boot
 *      faster to develop than traditional spring
 *      java apps become as easy as Grails or Rails apps
 *          but with JVM robustness and scalability
 *      easy to incorporate other spring modules
 *  Spring cloud requires spring boot
 *      relies on spring boot-style configuration and starter POM's
 *
 * Qualifications Test
 *  Microservices are not for everyone
 *      it is as much how you develop as what you develop
 *  Use microservice if:
 *      Rapid provisioning
 *      basic monitoring
 *      rapid application development
 *      a DevOps culture
 *
 * route to Microservices: New App
 *  Start with a Monolith
 *      keep it simple
 *      single process application
 *      apply 12 factor patterns
 *      cloud ready at this stage
 *  As it grows
 *      decompose into microservices
 *      enables separately manageable and deployable units
 *      each can use own storage solution polyglot persistence
 *
 * route to Microservices: existing app
 *  develop new functionality as a microservice(s) around existing single process application
 *      use Facades, Adapters, translators to integrate them
 *  Strangle the Monolith
 *      refactor existing monilith functionality into new microservice(s)
 *      long term evolution
 *          monolith withers to nothing
 *          or is reduced to a solid, reliable core that is not worth refactoring
 * Decomposing the Monolith
 *  Many java applications use the classic three-layer internal architecture
 *      services
 *      repositorues
 *      ifrastructure(interface to external resources)
 *      web layer(optional)
 *  Refactor as two processes
 *      the microservice is a service (or set of services)
 *          refactor at service(s) layer
 *
 *          e.g. primary application[web layer -> client service -> account service(REST)] -----> agreed protocol
 *          -----> microservice[web layer(REST) -> account service -> repository -> cloud platform services]
 *
 * Services vs Microservices
 *  in the multi layer architecture used throughout the course
 *      service layer service groups related business logic e.g. accounts, customers, audit, users
 *  separation of concerns
 *      separates data manipulation from data storage
 *
 *  A microservice is a process that wraps up multiple service layer services
 *      typically all the data that belongs in the same data store
 *  Example :online shop
 *      store
 *          acounts, customer, inventory, invoices
 *          one microservice, typically using a transactional db
 *      product catalog
 *          separate service using a document store
 *      shopping carts
 *          separate service using key-value store
 *
 * Spring Cloud
 *  Building blocks for Cloud and Microservice applications
 *      microservice architecture
 *          wraps up and makes available useful resources
 *          several based on other open source projects
 *              netfix, hashicoprs consul,
 *      cloud independence
 *          access cloud-specific information and services
 *          support for Cloud Foundry, AWS and Heroku
 *          or run without any cloud at all
 *      Uses spring boot starters
 *          requires spring boot to work
 *
 * See page 391 for projects under Spring cloud
 *
 * Spring Cloud Usage examples
 *  use cases
 *      cloud integration, dynamic reconfiguration, service discovery, security, data integration
 *
 * Communication between microservices
 *  How to set up and use a services registry?
 *  How do the services find each other?
 *
 *      REST request/JSON response are typically used
 *          How do the two services find each other?
 *          What happens if we run into multiple instances?
 *
 * Registry servers for Microservers
 *  Two popular open source registry Services
 *      Eureka
 *          created by Netflix
 *      Consul.io
 *          Hashicorp project
 *  Spring cloud makes it easy
 *      to set up any of those servers
 *          or switch between them
 *      to use either for service discovery
 *
 * Building a microservice system
 *
 *      See main pom.xml for dependencies
 *
 *      a) Run a discovery service
 *          create a eureka discovery service
 *      b) run a microservice
 *          ensure it registers itself with a discovery service
 *      c) how do microservice clients find the service?
 *          inject a "smart" Rest Template
 *              spring provides service lookup for you
 *              uses logical service names in URLS
 *
 *
 *
 *   Creating a Eureka server using Spring cloud
 *      All that is needed: implement your own registry service
 *      see {@link za.co.mahadew.damien.DiscoveryServiceExample}
 *      see application.yml
 *
 *   Creating a discovery client example
 *      each microservice declares itself a discovery-client
 *          using @EnableDiscoveryClient
 *          registers using application name
 *      see {@link za.co.mahadew.damien.DiscoveryClientExampleMicroservice}
 *       see application.yml
 *
 * Intelligent Routing
 *  Spring cloud automatically integrates two netflix utilities
 *      Eureka service discovery
 *      Ribbon load balancer
 *  end result
 *      determines the best available service to use(when there are multiple
 *      instances of a microservice)
 *      just inject the load-balanced rest template
 *      automatic lookup by logical service name
 *
 *
 * Summary
 *  What is a microservice architecture?
 *  Advantaes and challenges of microservices
 *  implementing using spring cloud projects
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */