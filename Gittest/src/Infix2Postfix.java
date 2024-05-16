
import java.util.Stack;
import java.util.StringTokenizer;

public class Infix2Postfix {
	public static String convert(String exp) {
		
/////////////.equals()를 ==으로 바꿈//////////////////
////////////오류 ==으로 할 경우 생김 .equals로 바꿔야 함 127p 7.4.2내용 참고
		if(exp == null || exp.length() == 0) return null; //빈문자나 NULL값에 대한 처리를 하기 위함(유효성 검사)
		StringTokenizer st = new StringTokenizer(exp, "+-*/()", true); //exp 문자열을 토큰으로 분리, 분리 기준 " "안에 있는 것들, true=분리기준도 토큰으로 포함(취급) 
		Stack<String> stack = new Stack<String>(); //스택 구현, 연산자와 괄호를 임시로 저장하는데 사용, 연산자의 우선순위에 따라 후위 표현식으로의 변환과정에 사용
		StringBuffer buf = new StringBuffer(); //문자열을 추가하거나 변경할 때 사용, 최종적으로 생성될 후위 표현식을 저장하는데 사용
		
		while(st.hasMoreTokens()) { //StringTokenizer 객체 st가 더 이상 토큰을 가지고 있지 않을 때까지 계속 반복, 입력된 식의 모든 토큰을 처리할 때까지 반복
			String tok = st.nextToken(); //nextToken()메소드를 호출하여 현재 토큰을 가져옴
			
			
			if(opType(tok) > 0) { //메소드가 토큰인지 확인, 연산자라면 0보다 큰값을 반환
				if (tok.equals("(")) { //"("를 만나면 스택에 푸시, 괄호 안의 연산 외부 연산보다 우선 처리
                    stack.push(tok);
                } else if (tok.equals(")")) { //")"를 만나면, 스택에서 "("를 만날 때까지 연산자를 팝하여 버퍼에 추가, 괄호 안의 연산 먼저 처리
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        buf.append(stack.pop()).append(" ");
                    }
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop(); // 여는 괄호 제거
                    }
                } else { //연산자를 만나면, 스택의 맨 위에 있는 연산자와 우선순위 비교 (getPriority 메소드 사용), 현재 연산자의 우선순위가 스택의 연산자보다 낮거나 같으면, 스택에서 연산자를 팝하여 버퍼에 추가 그 후 현재 연산자를 스택에 푸시
                    while (!stack.empty()){
                    	String op2 =stack.peek();
                    	int p1 =getPriority(tok.charAt(0));
                    	int p2 =getPriority(op2.charAt(0));
                    	if(p1 <= p2) {
                    		buf.append(stack.pop());	//op2를 stack.pop()로 바꾸면 2*3+1이 안되는 오류 해결							
                    		buf.append(" ");
                    	}else break;
    	            }
                    stack.push(tok.trim());
                }
            } else { //토큰이 연산자가 아니라면 (즉, 숫자나 변수라면), 버퍼에 바로 추가
                buf.append(tok.trim());
                buf.append(" ");
            }
        }
			
				
				
				
				/*
				while(!stack.empty()){
					String op2 =stack.peek();
					int p1 =getPriority(tok.charAt(0));
					int p2 =getPriority(op2.charAt(0));
					if(p1 <= p2) {
						buf.append(stack.pop());
						buf.append(" ");
					}else break;
							
					
					
					
				}
				stack.push(tok.trim());
			} else if (")".equals(tok)) {
                while (!stack.empty() && !"(".equals(stack.peek())) {
                    buf.append(stack.pop());
                    buf.append(" ");
                }
                if (!stack.empty() && "(".equals(stack.peek())) {
                    stack.pop();
                }
            } else if (!"(".equals(tok)) {
                buf.append(tok.trim());
                buf.append(" ");
            }
        }
		*/
		
		
		
		while(!stack.empty()) {
			buf.append(stack.pop());
			buf.append(" ");
		}
		return buf.toString();
	}
	
	public static int opType(String op) {
		op = op.trim();
		if(op.length() > 1 || op.length() == 0) {
			return -1;
		}
		char c= op.charAt(0);
		switch (c) {
			case '+':
				return 1;
			case '-':
				return 2;
			case '*':
				return 3;
			case '/':
				return 4;
			case '(':
				return 5;
			case ')':
				return 6;
		}
		return -1;
	}
	
	private static int getPriority(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		default:
			return -1;
		}
	}
	
	public static void main(String[] args) {
		String exp="12 + 2.5 * 5";
		System.out.printf("%s => %s %n", exp, Infix2Postfix.convert(exp));
	}
}
