package Iterator2;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
//move through article components
public class ArticleIterator implements Iterator<ArticleComponent> {
    private Stack<Iterator<ArticleComponent>> stack = new Stack<>();

    public ArticleIterator(List<ArticleComponent> components) {
        stack.push(components.iterator());
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<ArticleComponent> iterator = stack.peek(); //view top f stack withput popping
            if (iterator.hasNext()) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }

    @Override
    public ArticleComponent next() {
        if (hasNext()) {
            Iterator<ArticleComponent> iterator = stack.peek();
            ArticleComponent component = iterator.next();
            if (component instanceof Article) {
                stack.push(((Article) component).getComponents().iterator());
            }
            return component;
        }
        return null;
    }
}
