package Iterator2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//implements iterable<article component> interface and returns articleitearor for its components
//before article only had add, delete and display methods, now we can return an article iterator so we can move through for loops for components
//iterator returns new ArticleIterator each time 
public class Article implements ArticleComponent, Iterable<ArticleComponent> {
    private List<ArticleComponent> components;

    public Article() {
        components = new ArrayList<>();
    }

    public void addComponent(ArticleComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null.");
        }
        components.add(component);
    }

    public void removeComponent(ArticleComponent component) {
        if (!components.contains(component)) {
            throw new IllegalStateException("Component not found in the article.");
        }
        components.remove(component);
    }

    public List<ArticleComponent> getComponents() {
        return components;
    }

    @Override
    public void display() {
        if (components.isEmpty()) {
            System.out.println("This article is blank");
        } else {
            for (ArticleComponent component : components) {
                component.display();
            }
        }
    }

    @Override
    public Iterator<ArticleComponent> iterator() {
        return new ArticleIterator(components);
    }
}
