public class HandScorer implements HandScorerInterface {
  public int score(StackInterface<Card> hand){
    int score = 0;
    int Count = 0;
    LinkedStack<Card> theStack = new LinkedStack<>();
    while(!hand.isEmpty()){
      Card card = hand.pop();
      theStack.push(card);
      if(card.getValue().equals("ace")){
        Count++;
      }
      else if(card.getValue().equals("jack") || card.getValue().equals("king") || card.getValue().equals("queen")){
        score +=10;
      }
      else{
        score += Integer.parseInt(card.getValue());
      }
    }
    while(Count>0){
      if(score + 11 >21){
        score +=1;
      }
      else{
        score +=11;
      }
      Count--;
    }
    while(!theStack.isEmpty()){
      hand.push(theStack.pop());
    }
    return score;
  }
}
