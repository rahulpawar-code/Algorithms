
# System-Design-Questions
Large scale system design and object oriented design questions and topics


# Table of Contents
1. [Keywords To Remember](#keywords-to-remember)
2. [Infrastructure Design Questions](#infrastructure-design-questions)
3. [System Design Questions](#web-service-design-questions)
4. [Object Oriented Design Questions](#object-oriented-design-questions)
5. [External References](#external-references)

# Keywords To Remember
## System features
* Distributed system
* Scalability 
* Redundancy 
* Responsiveness
* Downtime
* Single point of failure
* Failover
* High throughput
* Wait time
* Traffic bottleneck

## Hardware resources/servers
* Web server
* Application server (App server)
* Database server (DB server)
* Cache server
* Key server (Key generator)
* ID server (ID generator)
* Load Balancing
* Firewall 

## Articles
* Latency Numbers Every Programmer Should Know [Link](https://gist.github.com/jboner/2841832)
* [Horizontal vs Vertical Scaling for Hardware and Databases](https://stackoverflow.com/questions/11707879/difference-between-scaling-horizontally-and-vertically-for-databases)

# Infrastructure Design Questions
* **General Architecture of Web Service** 
	* [Web Architecture 101](https://engineering.videoblocks.com/web-architecture-101-a3224e126947)
* **Messaging Queue**
	* [Video](https://www.youtube.com/watch?v=oUJbuFMyBDk)
* **Caching** - Design a caching system
	* [Caching](https://www.educative.io/courses/grokking-the-system-design-interview/3j6NnJrpp5p)
	* [Design a cache system](http://blog.gainlo.co/index.php/2016/05/17/design-a-cache-system/)
	* [Design a distributed key value caching system](https://www.interviewbit.com/problems/design-cache/)
	* [Cache wiki](https://en.wikipedia.org/wiki/Cache_(computing))
	* [Application vs. database caching](https://lethain.com/introduction-to-architecting-systems-for-scale/)
* **Load balancer** - Design a load balancer
	* [Load Balancer](https://www.educative.io/courses/grokking-the-system-design-interview/3jEwl04BL7Q)
	* [Load Balancing wiki](https://en.wikipedia.org/wiki/Load_balancing_(computing))
	 * [What is load balancing](https://avinetworks.com/what-is-load-balancing/)

* **Database sharding**
	* [Database sharding](https://www.digitalocean.com/community/tutorials/understanding-database-sharding)
	* [Sharding wiki](https://en.wikipedia.org/wiki/Shard_(database_architecture))
* **Hit Counter** - Design a hit counter
	* [Design Hit Counter](http://blog.gainlo.co/index.php/2016/09/12/dropbox-interview-design-hit-counter/)
	* [Hit counter various design and data structures](https://massivetechinterview.blogspot.com/2015/06/algorithm-how-to-count-number-of.html)

# Web Service Design Questions

* **Netflix** Design messanger service 
	* [Design Media Streaming Platform](https://techtakshila.com/system-design-interview/chapter-2)

* **Whatsapp** Design messanger service 
	* [Service based design and various infrastructure topics video](https://www.youtube.com/watch?v=RjQjbJ2UJDg)
	* Design [Link1](https://medium.com/codingurukul/whatsapp-engineering-inside-1-1ef4845ff784) [Link2](https://medium.com/codingurukul/whatsapp-engineering-inside-2-bdd1ec354748)
	* [Messaging service video](https://www.youtube.com/watch?v=WzBzYX1aSrU)
	* [Design Instant Messenger - WhatsApp](https://techtakshila.com/system-design-interview/chapter-1)

* **Twitter**
	* **Points to remember** - Data Modelling, Feed Ranking (Ranking algorithm and ML algorithm), Feed Publishing, @mention feature,  #hashtags and trending topics, who to follow, moments feature, search
	* **How to design Twitter** [Part 1](http://blog.gainlo.co/index.php/2016/02/17/system-design-interview-question-how-to-design-twitter-part-1/) [Part 2](http://blog.gainlo.co/index.php/2016/02/24/system-design-interview-question-how-to-design-twitter-part-2/)
	* [Twitter system web infrastructure](https://github.com/donnemartin/system-design-primer/tree/master/solutions/system_design/twitter)

* **Ride Hailing Platform**
	* [Design Uber platform](https://techtakshila.com/system-design-interview/chapter-3)

* **Facebook News Feed** - Design Facebook like news feed system
	* **Points to remember** - Data Modeling, Feed Ranking using EdgeRank algorithm, Feed publishing
	* [EdgeRank for Facebook newsfeed](https://medium.com/@bansal_ankur/design-a-news-feed-system-6bf42e9f03fb)
	* News Feed system [Part 1](http://blog.gainlo.co/index.php/2016/03/29/design-news-feed-system-part-1-system-design-interview-questions/) [Part 2](http://blog.gainlo.co/index.php/2016/04/05/design-news-feed-system-part-2/)
	* [Feed system](https://massivetechinterview.blogspot.com/2015/08/design-news-feed-system-medium.html)
	
* **Photo sharing service** (Instagram) - Design a photo sharing service like Instagram, Flickr, Picasa
	* [Design Instagram](https://www.educative.io/courses/grokking-the-system-design-interview/m2yDVZnQ8lG)
	* [Design photo sharing app](http://blog.gainlo.co/index.php/2016/03/01/system-design-interview-question-create-a-photo-sharing-app/)

* **URL Shortening** - Design a URL shortening service
	* [Designing a URL Shortening service like TinyURL](https://www.educative.io/courses/grokking-the-system-design-interview/m2ygV4E81AR)
	* [Design a TinyURL service](http://blog.gainlo.co/index.php/2016/03/08/system-design-interview-question-create-tinyurl-system/)
	* [URL shortening wiki](https://en.wikipedia.org/wiki/URL_shortening)

* **Prefix Search (Auto completion)**
	* [Prefix search service](https://medium.com/@prefixyteam/how-we-built-prefixy-a-scalable-prefix-search-service-for-powering-autocomplete-c20f98e2eff1) 
	* [Typeahead](https://en.wikipedia.org/wiki/Typeahead)

# Object Oriented Design Questions

* **Tic Tac Toe** - Design a tic tac toe game
	* [Classs diagrams](https://medium.com/system-designing-interviews/design-tic-tac-toe-game-1b912bba64cf)

* **Chess** - Design a chess game
	* [OO design of Chess game](https://www.geeksforgeeks.org/design-a-chess-game/)
	* [Design a chess game](https://medium.com/system-designing-interviews/design-a-chess-game-dddd7ba11bc0)

* **Elevator system** - Design an elevator system
	* [OO design of elevator system](https://massivetechinterview.blogspot.com/2015/07/thought-works-object-oriented-design.html)

* **Snake game**
	* [OO design](https://massivetechinterview.blogspot.com/2015/10/snake-game-design.html)


# External References
1. https://www.educative.io/courses/grokking-the-system-design-interview
2. [Gainlo blog](http://blog.gainlo.co/index.php/category/system-design-interview-questions/)
3. [Massive technical interviews](https://massivetechinterview.blogspot.com/2015/06/algorithm-how-to-count-number-of.html)
4. [System Design Primer](https://github.com/donnemartin/system-design-primer)
5. [Interview Bit](https://www.interviewbit.com/)
