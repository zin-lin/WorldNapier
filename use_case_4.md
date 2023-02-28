# USE CASE: 4 Produce a report for the population of a particular country

## CHARACTERISTIC INFORMATION

### Goal in Context

As an employee of the population report organisation, I must be able to produce a report for the population of a particular country

### Scope

Company

### Level

Primary task

### Preconditions

The population of countries data is in the database

### Success End Condition

A report is made with the population of a certain country

### Failed End Condition

No report is made

### Primary Actor

Organisation Software Engineer

### Trigger

A request for a country population report to be made

## MAIN SUCCESS SCENARIO

1. A request for a country population report to be made
2. Software engineer captures the name of the country to get data set for.
3. Software engineer extracts information from the database
3. Report is made with the population of the country

## EXTENSIONS

3. If name of country doesn't exist:
        i: Software engineer informs organisation country doesn't exist in the databse 


## SCHEDULE

**DUE DATE**: v0.1-alpha-3

