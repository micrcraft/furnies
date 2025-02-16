import os
import json

# Generate the blockstate JSON data for the bench
def get_blockstate(wood):
    # Define the rotation for each facing direction
    directions = {
        "north": 0,
        "east": 90,
        "south": 180,
        "west": 270
    }
    variants = {}
    # For each direction and each connection type, set the model path and rotation (if needed)
    for direction, rotation in directions.items():
        for conn in ["single", "left", "middle", "right"]:
            key = f"facing={direction},connection_type={conn}"
            entry = {"model": f"furnies:block/bench/{wood}_{conn}"}
            if rotation:
                entry["y"] = rotation
            variants[key] = entry
    return {"variants": variants}

# Generate the "single" block model JSON data
def get_single_model(wood):
    return {
        "parent": "furnies:block/template/bench_single",
        "textures": {
            "1": f"furnies:block/bench/{wood}"
        }
    }

# Generate the "left" block model JSON data
def get_left_model(wood):
    return {
        "parent": "furnies:block/template/bench_left",
        "textures": {
            "1": f"furnies:block/bench/{wood}"
        }
    }

# Generate the "middle" block model JSON data
def get_middle_model(wood):
    return {
        "parent": "furnies:block/template/bench_middle",
        "textures": {
            "1": f"furnies:block/bench/{wood}"
        }
    }

# Generate the "right" block model JSON data
def get_right_model(wood):
    return {
        "parent": "furnies:block/template/bench_right",
        "textures": {
            "1": f"furnies:block/bench/{wood}"
        }
    }

# Generate the item model JSON data
def get_item_model(wood):
    return {
        "parent": f"furnies:block/bench/{wood}_single",
        "textures": {
            "1": f"furnies:block/bench/{wood}"
        }
    }

# Utility function to save a JSON file
def save_json_file(path, data):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=4)

# Main function to generate all files for each wood type
def generate_files():
    # Read wood types from woods.json (example: ["spruce", "oak", ...])
    script_dir = os.path.dirname(os.path.abspath(__file__))
    woods_file = os.path.join(script_dir, "woods.json")
    with open(woods_file, "r", encoding="utf-8") as f:
        woods = json.load(f)
    
    # Base directory for generated files
    base_dir = os.path.join(script_dir, "furnies")
    
    for wood in woods:
        # Generate blockstate file: furnies/blockstates/<wood>_bench.json
        blockstate_path = os.path.join(base_dir, "blockstates", f"{wood}_bench.json")
        save_json_file(blockstate_path, get_blockstate(wood))
        
        # Generate block model files in furnies/models/block/bench/
        bench_models_dir = os.path.join(base_dir, "models", "block", "bench")
        save_json_file(os.path.join(bench_models_dir, f"{wood}_single.json"), get_single_model(wood))
        save_json_file(os.path.join(bench_models_dir, f"{wood}_left.json"), get_left_model(wood))
        save_json_file(os.path.join(bench_models_dir, f"{wood}_middle.json"), get_middle_model(wood))
        save_json_file(os.path.join(bench_models_dir, f"{wood}_right.json"), get_right_model(wood))
        
        # Generate item model: furnies/models/item/<wood>_bench.json
        item_model_path = os.path.join(base_dir, "models", "item", f"{wood}_bench.json")
        save_json_file(item_model_path, get_item_model(wood))

if __name__ == "__main__":
    generate_files()
