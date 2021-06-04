package org.tian.news.sevice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.tian.news.entity.Category;
import org.tian.news.entity.NewsTmp;
import org.tian.news.mapper.CategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {

    private static Map<Integer, String> categoryMap;

    /**
     *
     * @return 类别Map    {《1，类别名》。。}
     */
    public Map<Integer, String> getCategoryMap(){
        if (categoryMap == null){
            List<Category> categoryList = list();
            // 构造类别map
            categoryMap = new HashMap<>();
            for (Category category : categoryList) {
                categoryMap.put(category.getCId(), category.getCName());
            }
        }
        return categoryMap;
    }

    /**
     *
     * @param categoryId
     * @return 类别名
     */
    public String getCategoryName(Integer categoryId){
        return getCategoryMap().get(categoryId);
    }

    public void fillCname(List<NewsTmp> list){
        for (NewsTmp newsTmp : list) {
            newsTmp.setNCategoryName(getCategoryName(newsTmp.getNCategoryId()));
        }
    }
}
