# Contributing to HypeChats

## Code of Conduct

Be respectful and inclusive. We welcome all contributions.

## Getting Started

1. Fork the repository
2. Clone your fork
3. Create a feature branch
4. Make your changes
5. Push to your branch
6. Open a pull request

## Code Style

### Kotlin
- Use Kotlin naming conventions
- Follow [Kotlin style guide](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable names
- Add comments for complex logic

### XML
- Use 4-space indentation
- Keep layout files organized
- Use android namespace for attributes

## Commit Messages

```
type(scope): subject

body

footer
```

### Types
- `feat` - New feature
- `fix` - Bug fix
- `docs` - Documentation
- `style` - Code style
- `refactor` - Code refactoring
- `test` - Testing
- `chore` - Build/dependency changes

### Examples
```
feat(chat): add message reactions
fix(api): handle network timeout
docs: update setup guide
refactor(viewmodel): simplify logic
```

## Pull Request Process

1. Update documentation if needed
2. Add tests for new features
3. Ensure all tests pass
4. Update CHANGELOG
5. Request review from maintainers

## Testing

### Unit Tests
```bash
./gradlew test
```

### Integration Tests
```bash
./gradlew androidTest
```

### Code Coverage
```bash
./gradlew jacocoTestReport
```

## Documentation

- Update README.md for major changes
- Add inline comments for complex code
- Update DOCUMENTATION.md if applicable
- Add examples for new features

## Reporting Issues

### Describe the bug
- Clear title and description
- Steps to reproduce
- Expected vs actual behavior
- Screenshots if applicable

### Suggest features
- Clear description
- Use case and benefits
- Implementation suggestions

## License

By contributing, you agree that your contributions will be licensed under the project's license.

---

Thank you for contributing!