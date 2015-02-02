# radial-encapsulation-maven-plugin

Inspired by http://edmundkirwan.com/general/radial.html

This maven plugin can:
<ul>
  <li>Print all classes that violate radial encapsulation.</li>
  <li>Break build if finds more than <i>maxViolations<i></li>
</ul>

Example usage:

```xml
<plugin>
    <groupId>com.mobilepetroleum.radialencapsulation</groupId>
    <artifactId>radial-encapsulation-maven-plugin</artifactId>
    <version>1.0.0</version>
    <configuration>
        <!-- Required. Analyze classes from this package. -->
        <basePackage>com.companyName.projectName</basePackage>
        <!-- Optional. Exclude classes from analyze. Regexp pattern for fully qualified class name. -->
        <!-- Dependencies from inner class are merged with its outer class dependencies. --> 
        <excludes>
            <exclude>.*Factory</exclude>
        </excludes>
        <!-- Optional. Default: true. Analyse test classes. -->
        <includeTestSources>false</includeTestSources>
        <!-- Optional. If specified, break build after exceeding maxViolations. -->
        <maxViolations>0</maxViolations>
    </configuration>
    <!-- Hook into process-classes phase. -->
    <!-- Alternatively run: mvn radial-encapsulation:radial-encapsulation -->
    <executions>
        <execution>
            <id>radial-encapsulation</id>
            <phase>process-classes</phase>
            <goals>
                <goal>radial-encapsulation</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
