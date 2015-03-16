#!/bin/sh
#
# Makefile for Yuan_leetcode
#


all:	clean count

clean:  
	\rm  -f *~ 

count:	
	ls | grep -c java 
