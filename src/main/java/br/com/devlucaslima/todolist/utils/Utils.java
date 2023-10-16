package br.com.devlucaslima.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

  public String[] getNullPropertiesNames(Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source);

    PropertyDescriptor[] propertyDescriptors = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<>();

    for(PropertyDescriptor pd: propertyDescriptors) {
      Object srcValue = src.getPropertyValue(pd.getName());
      if(srcValue == null) {
        emptyNames.add(pd.getName());
      }
    }

    String[] result = new String[emptyNames.size()];
    return emptyNames.toArray(result);
  }
}
