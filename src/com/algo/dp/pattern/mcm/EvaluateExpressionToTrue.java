package com.algo.dp.pattern.mcm;

/**
 * Given a boolean expression, a string with True or False as operands and
 * between each pair of operand, there is boolean operator (and &, or | and xor
 * ^). Find number of ways in which this Boolean expression can be parenthesized
 * so that expression evaluates to True. This is known as Boolean
 * Parenthesization problem. To understand problem better, let’s take some
 * examples Expression :
 * 
 * T ^ F & T
 * 
 * Two ways :
 * 
 * ((T ^ F) & T) and (T ^ (F & T))
 * 
 * boolean parenthesization problem
 * 
 * T | T & F ^ T
 * 
 * Four ways :
 * 
 * ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T))
 * 
 *
 */
public class EvaluateExpressionToTrue {

}
