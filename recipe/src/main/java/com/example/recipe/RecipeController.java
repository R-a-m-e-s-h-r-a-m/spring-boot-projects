package com.example.recipe;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RecipeController {
    private RecipeService recipeService = new RecipeService();

    // API 1: Get all recipes
    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // API 2: Add a new recipe
    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    // API 3: Get a recipe by ID
    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable int recipeId) {
        return recipeService.getRecipeById(recipeId);
    }

    // API 4: Update an existing recipe
    @PutMapping("/recipes/{recipeId}")
    public Recipe updateRecipe(@PathVariable int recipeId, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipeId, recipe);
    }

    // API 5: Delete a recipe
    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable int recipeId) {
        recipeService.deleteRecipe(recipeId);
    }
}
