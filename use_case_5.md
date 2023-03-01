# USE CASE: 5 Produce a report for the population of a particular district.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an employee of the population report organisation, I must be able to produce a report for the population of a particular district.

### Scope

Company

### Level

Primary task

### Preconditions

The population of district data is in the database

### Success End Condition

A report is made with the population of a district

### Failed End Condition

No report is made

### Primary Actor

Organisation Software Engineer

### Trigger

A request for a district population report to be made

## MAIN SUCCESS SCENARIO

1. A request for a district population report to be made
2. Software engineer captures the name of the district to get data set for.
3. Software engineer extracts information from the database
3. Report is made with the population of a district

## EXTENSIONS

3. If name of district doesn't exist:
        i: Software engineer informs organisation district doesn't exist in the databse 


## SCHEDULE

**DUE DATE**: v0.1-alpha-3

